(function () {
	// 案件內容中的Content做資料變動, 連動更新其他Content, 所以重載此案件內容之所有Content
	$.isRefreshContent = function (callback) {
		var url = window.location.href;
		var pos = url.indexOf('#');
		
		if (pos > 0) {
			var flag = url.substring(pos);
			var orderMId = flag.split(':')[1];
			
			if (!orderMId) {
	    		url = url.replace(flag, '');
	    		window.history.pushState("", "", url);
	    		
				return;
			}
			
			var settings = {
				httpMethod: 'GET', 
				URL: contextPath + '/flow/re-enetity-buz-order-flow.action?orderMId=' + orderMId, 
				dataType: 'html',
			    success: function(data) {
			    	if(data) {
			    		url = url.replace(flag, '');
			    		window.history.pushState("", "", url);
			    		callback(data, orderMId);
			    	}
			    }
			}
			$.formAjax(settings);
			$('div#info').hide();
		}
	}
	
	// 驗證是否已經勾選了checkbox 
	$.hasChecked = function($checkboxs, msgCode) {
		var checked = false;
		
		$checkboxs.each(function() {
			if($(this).prop("checked")) {
				checked = true;

				return false;
			}
		});
		
		if(!checked) {
			$.warningMsg(msgCode);
			
			return false;
		}
		
		return true
	}
	
	// 檢查各種證號之輸入欄位
	$.validateCardNumbers = function (cardNumber, count) {
		var isNumber = $.isNumeric(cardNumber);
		var length = cardNumber.length;

		if (!cardNumber) {
			return false;
		}
		
		if (!count) {
			count = length;
		}
		
		if (!isNumber || cardNumber < 0 || length != count) {
			return true;
		}
		
		return false;
	}
	
	// 檢查門號
	$.validateMsisdn = function(msisdn) {
		var re = /^[09]{2}[0-9]{8}$/;
		var result = false;

		if (re.test(msisdn)) {
			result = true;
		}

		return result;
	}
	
	// 檢查身分證
	$.validateIdentityCard = function (cardNumber) {
		var re = /^[A-Za-z]{1}[1-2]{1}[0-9]{8}$/;
		var result = false;

		// step1 檢查格式
		if (!re.test(cardNumber)) {
			return false;
		}
		
		cardNumber = cardNumber.toUpperCase();
		
		// step2 檢查公式
		var city = new Array(1,10,19,28,37,46,55,64,39,73,82, 2,11,20,48,29,38,47,56,65,74,83,21,3,12,30);
		var cardNumberArray = cardNumber.split(""); //轉為array
		
		var total = city[cardNumberArray[0].charCodeAt(0)-65];
        
        for (var i =1; i<=8; i++) {
            total += cardNumberArray[i] * (9 - i);
        }
        
        total += cardNumberArray[9] * 1;
        
        if (total%10==0) {
            result = true;
        }

		return result;
	}
	
	// 檢查統編
	$.validateTaxIdNumber = function (cardNumber) {
		var re = /^[0-9]{8}$/;
		var result = false;

		// step1 檢查格式
		if (!re.test(cardNumber)) {
			return false;
		}

		// step2 檢查公式
		var cardNumberArray = cardNumber.split(""); //轉為array
		var multiple = new Array(1,2,1,2,1,2,4,1);
		var total = 0;

        for (var i = 0; i < 8; i++) {
        	var temp = cardNumberArray[i] * multiple[i];
        	var temp2 = parseInt(temp/10) + temp%10;
        	
            total += temp2;
        }
        
        if (total%10 == 0) {
            result = true;
        } else {
        	// 額外 判斷第七碼是否為7，有另一規則
        	if (cardNumberArray[6] == 7) {
        		var total2 = 0;
        		
                for (var i = 0; i < 8; i++) {
                	var temp1 = 0;
                	var temp2 = 0;
                	
                	if (i != 6) {
                    	var temp = cardNumberArray[i] * multiple[i];
                    	temp2 = parseInt(temp/10) + temp%10;
                	} else {
                    	var temp = cardNumberArray[i] * multiple[i];
                    	temp1 = parseInt(temp/10) + temp%10;
                    	temp2 = parseInt(temp1/10) + temp1%10;
                	}
                	
                    total2 += temp2;
                }
                
                if (total2%10 == 0) {
                	result = true;
                }
        	}
        }

		return result;
	}
	
	// 將案件狀態加上提示燈號
	$.setOrderStatusMark = function (row) {
		if (row) {
			var lightColor = row.LIGHT_COLOR;
			var matchs = {
				'yellow': '<span class="t-tag tag-warning"></span>',
				'green': '<span class="t-tag tag-success"></span>',
				'blue': '<span class="t-tag tag-primary"></span>'
			};

			if (lightColor) {
				try {
					row.ORDER_STATUS += matchs[lightColor];
				} catch (e) {
					$.warnginMsg('022');
				}
			}
		}
		
		return row;
	}
	
	// 將緊急案件的資料字體顏色設定成紅色
	$.setEmergencyCase = function(row) {
		if (row) {
			var flag1 = row.OVERDUE_FLAG;
			var flag2 = row.CRITICAL_FLAG;
				
			if(flag1 == 'Y' || flag2 == 'Y') {
				$.each(row, function(i) {
					row[i] = '<p style="color: red;">' + row[i] + '</p>';
				});
			}
		}
		
		return row;
	}
	
	// 控制左邊menu [ 開啟 ] 的時候內容「表單」的排版
	$.setMenuOpen = function ($target, cssPrefix) {
		var $datetimes = $target.find('[class$=' + cssPrefix + '_close_datetime]');
		$datetimes.removeClass(cssPrefix + '_close_datetime').addClass(cssPrefix + '_open_datetime');
		$.each($datetimes, function(i, datetime){
			var $picker1 = $(datetime).find('[class$=' + cssPrefix + '_close_datetime_1]');
			var $picker2 = $(datetime).find('[class$=' + cssPrefix + '_close_datetime_2]');
			
			$picker1.removeClass(cssPrefix + '_close_datetime_1').addClass(cssPrefix + '_open_datetime_1');
			$picker2.removeClass(cssPrefix + '_close_datetime_2').addClass(cssPrefix + '_open_datetime_2');
		});
		
		var $rows = $target.find('[class*=' + cssPrefix + '_close_row]');
		$.each($rows, function(i, row) {
			$(row).removeClass(cssPrefix + '_close_row' + (i+1)).addClass(cssPrefix + '_open_row' + (i+1));
		});
	}
	
	// 控制左邊menu [ 關閉 ] 的時候內容「表單」的排版
	$.setMenuClosed = function ($target, cssPrefix) {
		var $datetimes = $target.find('[class$=' + cssPrefix + '_open_datetime]');
		$datetimes.removeClass(cssPrefix + '_open_datetime').addClass(cssPrefix + '_close_datetime');
		$.each($datetimes, function(i, datetime){
			var $picker1 = $(datetime).find('[class$=' + cssPrefix + '_open_datetime_1]');
			var $picker2 = $(datetime).find('[class$=' + cssPrefix + '_open_datetime_2]');
			
			$picker1.removeClass(cssPrefix + '_open_datetime_1').addClass(cssPrefix + '_close_datetime_1');
			$picker2.removeClass(cssPrefix + '_open_datetime_2').addClass(cssPrefix + '_close_datetime_2');
		});
		
		var $rows = $target.find('[class*=' + cssPrefix + '_open_row]');
		$.each($rows, function(i, row) {
			$(row).removeClass(cssPrefix + '_open_row' + (i+1)).addClass(cssPrefix + '_close_row' + (i+1));
		});
	}
	
	// checkbox全選 
	$.setCheckBoxAllCheckedEvent = function($checkAll) {
		// 注意: 在對元件綁定事件之前, 最好先執行unbind( 解除綁定 )語法, 避免元件被重複觸發之問題 
		$checkAll.unbind('click').on('click', function() {
			var $checkboxs = $("table input:checkbox");
			
			if($checkAll.prop("checked")) {
				$checkboxs.each(function() {
					$(this).prop("checked", true);
				}); 
			} else {
				$checkboxs.each(function() {
					$(this).prop("checked", false);
				});
			};
		});
	}
	
	// 依據案件單號彈出對應影像視窗
	$.popOrderImageWindow = function(orderMId) {
		var settings = {
			httpMethod: 'POST', 
			URL: contextPath + '/flow/get-order-image-url.action',
			dataType: 'html',
			dataProvider: function() {
				var orderProcess = {};
				
				orderProcess.orderMId = orderMId;
				
				return REQ_PARAM_JSON_DATA + '=' + encodeURIComponent(JSON.stringify(orderProcess));
			}, 
		    success: function(jsonData) {
		    	if(jsonData) {
		    		var jsonoObj = JSON.parse(jsonData);
		    		var url = jsonoObj.link;
		    		var browserType = jsonoObj.browser;
		    		
		    		popWindow(url, browserType);
		    	}
		    }
		}
			
		$.formAjax(settings);
	}
	
	// 依據指定來源系統屬性彈出對應視窗
	var popWindow = function(url, browserType) {
		var setting = {
			directLink : true,
			url : url
		};
		var matchs = {
			'ie': function() {
				var urlDecodeFlag = "true";
				var singleFlag = "false";
				
				doOpenBrowser(browserType, url, urlDecodeFlag, singleFlag);
			},
			'chrome': function() {
				$.openWin(setting);
			}
		};
		
		try {
			matchs[browserType.toLowerCase()]();
		} catch (e) {/* 若抓到Exception則不彈出視窗 */}
	}
	
	// 檢核日期合法性
	$.checkDateLegitimate = function(validateDate) {
		if (Object.prototype.toString.call(validateDate) === "[object Date]") {
			if (isNaN(validateDate.getTime())) {

				return false;
			}
		}

		return true;
	}
	
	/*
	 * 1. 檢核日期選擇是否空白
	 * 2. 起訖間隔不超過三個月
	 */ 
	$.dateValidator = function($begin, $end) {
		return $.dateValidatorWithRange($begin, $end, 3);
	}
	$.dateValidatorWithRange = function($begin, $end, range) {
		var begin = $begin.val();
		var end = $end.val();

		if (!$.checkDateLegitimate(new Date(begin))) {
			$.warningMsg('026');
			
			return false;
		}

		if (!$.checkDateLegitimate(new Date(end))) {
			$.warningMsg('026');
			
			return false;
		}
		
		if (end < begin) {
			$.warningMsg('026');
			
			return false;
		}
		
		if(!begin || !end) {
			$.warningMsg('010');
			
			return false;
		}
		
		var threeMonthAgo = moment(end).subtract(range, 'month').format('YYYY-MM-DD hh:mm');
		if(begin < threeMonthAgo) {
			$.warningMsg('011');
			
			return false;
		}
		
		return true;
	}

	// 檢核起迄日期不得錯置
	$.dateValidatorWithoutRange = function($begin, $end) {
		var begin = $begin.val();
		var end = $end.val();

		if (!$.checkDateLegitimate(new Date(begin))) {
			$.warningMsg('026');
			
			return false;
		}
		
		if (!$.checkDateLegitimate(new Date(end))) {
			$.warningMsg('026');
			
			return false;
		}

		if (end < begin) {
			$.warningMsg('026');
			
			return false;
		}
		
		if(!begin || !end) {
			$.warningMsg('010');
			
			return false;
		}
		
		return true;
	}
	
	$.destoryDataTable = function($table) {
    	var $tbody = $table.find('tbody');
    	
    	if($tbody.has('tr').length) {
    		$table.dataTable().fnDestroy();
    	}
	}
	
	// 使用Monment套件格式化日期字串為指定格式
	$.formatter = function(dateString, format) {
		return moment(dateString).format(format);
	}
	
	$.getSuccessMessage = function(code) {
		return getSuccess(code);
	}
	
	$.getQuestionMessage = function(code) {
		return getQuestion(code);
	}
	
	$.getErrorMessage = function(code) {
		return getError(code);
	}
	
	$.getFileType = function(type) {
		return getFileType(type);
	}
	
	// 定義Bootstrap Modal關閉的時候需要做甚麼事情, 防止使用者點擊Modal以外區域或右上角的x按鈕
	$.afterModalClosed = function($modal, callback) {
		$modal.unbind('hidden.bs.modal').on('hidden.bs.modal', callback);
	}

	// 設定DateTimePicker的預設值
	$.setDateTimePickerDefaultValue = function() {
		var d = new Date();
		var month = d.getMonth()+1;
		var day = d.getDate();
		var output = d.getFullYear() + '-' + (month<10 ? '0' : '') + month + '-' + (day<10 ? '0' : '') + day;
		var $inputStartDate = $('div.osp_datetime_1 input');
		var $inputEndDate = $('div.osp_datetime_2 input');

		$inputStartDate.val(output + " 00:00");
		$inputEndDate.val(output + " 23:59");
	}
	
	/* Inner Method
	==================================================================================================================== */
	var getSuccess = function(code) {
		var message = {
			'001': '轉派成功!',
			'002': '暫停分派成功!',
			'003': '編輯成功!',
			'004': '新增成功!',
			'005': '貼標成功!',
			'006': '上傳成功!',
			'007': '設定成功!',
			'008': '項目內容已新增完成!',
			'009': '寄件成功!'
		};
		
		return message[code];
	}
	
	var getQuestion = function(code) {
		var message = {
			'001': '確認刪除!?'
		};
		
		return message[code];
	}
	
	var getError = function(code) {
		var message = {
			'001': '轉派失敗!',
			'002': '分派失敗!',
			'003': '編輯失敗!',
			'004': '新增失敗!',
			'005': '貼標失敗!',
			'006': '上傳失敗!',
			'007': '設定失敗!',
			'008': '必須選擇Excel檔案!',
			'009': '角色名稱或角色類別不可空白!',
			'010': '請輸入開始日期或結束日期!',
			'011': '日期期間不可超過3個月!',
			'012': '必須選擇一個OSP單號!',
			'013': '判斷進件時間若勾選。則不可空白!',
			'014': '固定處理時間若勾選。則不可空白!',
			'015': '請輸入門號!',
			'016': '請選擇進件來源!',
			'017': '有效案件處理時間不可空白!',
			'018': '無效案件處理時間不可空白!',
			'019': '「判斷進件時間」、「固定處理時間」至少需勾選一項!',
			'020': '若選擇「統一編號」或「稅籍編號」時, 公司負責人證照號碼欄位不可空白!',
			'021': '寄件失敗!',
			'022': '找不到對應的案件提示燈號!',
			'023': '請輸入促銷代碼!',
			'024': '請選擇案件類別!',
			'025': '找不到該檔案!',
			'026': '請檢查日期區間日否有誤!',
			'027': '門號欄位輸入錯誤!',
			'028': '公司負責人證照號碼輸入錯誤!',
			'029': '件數欄位中不可包含文字!',
			'030': '件數欄位中不可空白!',
			'031': '請輸入角色名稱!',
			'032': '必須選擇人員!',
			'033': '請輸入班別代號!',
			'034': '請檢查門號清單是否正確!',
			'035': '請至少勾選一組門號資料!',
			'036': '請選擇通知業者!',
			'037': '查無資料!',
			'038': '查無業務員編!',
			'039': '初始化 AppartAgent 失敗!'
		};
		
		return message[code];
	}
	
	var getFileType = function(type) {
		var message = {
			'xlsxType': 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
			'xlsType': 'application/vnd.ms-excel'
		};
		
		return message[type];
	}
	
})();