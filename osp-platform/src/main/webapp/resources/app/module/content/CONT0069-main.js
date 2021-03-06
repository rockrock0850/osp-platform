require([ 'cont0069-service', 'osp-ui-app', 'small-modal' , 'form2object', 'osp-util', 'flip', 
          'common-util', 'cookie'], function(cont0069_Service,uiApp) {
	$("div#uploadContentNGMVPN input[name='file']").on('change', function(e) {
		cont0069_Service.chooseFile();
	});
	
	$("div#uploadContentNGMVPN button#uploadButton").click(function() {
		cont0069_Service.uploadFile();
	});
});

//----------------------------------------------------------------

(function() {
	define('cont0069-service', [ 'small-modal'],function() {
	
	//檢查是否有上傳過檔案的開關
	var uploaded = false;
	
	/**
	 * 驗證EXCEL
	 */
	var chooseFile =  function(id) {
		var $fileName = $("div#uploadContentNGMVPN span#fileName");
		var $input = $("div#uploadContentNGMVPN input[type='file']");
		var $uploadButton = $("div#uploadContentNGMVPN button#uploadButton");
		var $chooseButton = $("div#uploadContentNGMVPN span[class$='btn-file']");
		
		$fileName.text("");
		
		/* 注意: 不知道為什麼input一定要加上[0]才能選到檔案清單物件 */
		var name = $input[0].files[0].name;
		   
		if(name != null) {
			$fileName.text(name);
			$uploadButton.show();
		}
	}
	
	/* 上傳檔案 */
	var uploadFile = function() {
		var $fileName = $("div#uploadContentNGMVPN span#fileName");
		var formData = new FormData();
		var files = $("div#uploadContentNGMVPN input[type='file']");// 多個file的陣列
		
		$.each(files,function(i) {
			// 因為每個input file都只會有一個檔案.所以將第i個file中的第一個檔案放入formData
			formData.append("file",files[i].files[0]);
		});
		
	    var $uploadButton = $("div#uploadContentNGMVPN button#uploadButton");
		var $chooseButton = $("div#uploadContentNGMVPN span[class$='btn-file']");
	    if(!$.isEmptyObject(formData)) {
		    $.ajax({
		        url: contextPath + '/flow/content/upload-ng-mvpn.action',
		        type: 'POST',
		        data: formData,
	            cache : false,
	            async: false,
		        contentType: false,
		        processData: false,
		        success: function () {
		        	//開關.若有上傳過Excel才會為true.並且允許執行後續的核對功能
		        	uploaded = true;
	
					var content = '<center><label>' + $.getSuccessMessage('006') + '</label></center>';
					var buttons = {
						cancelButton: {
							value: '確認'
						}
					}
		        	$.messageModal('訊息', content, buttons);
		        }, 
		        error: function(error) {
		        	console.log(error);
					var content = '<center><label>' + $.getErrorMessage('006') + '</label></center>';
					var buttons = {
						cancelButton: {
							value: '確認'
						}
					}
		        	$.messageModal('警告', content, buttons);
		        }
		    });
	
	    } else {
			var content = '<center><label>' + $.getErrorMessage('006') + '</label></center>';
			var buttons = {
				cancelButton: {
					value: '確認'
				}
			}
        	$.messageModal('警告', content, buttons);
	    }
	    
		$uploadButton.hide();
		$chooseButton.show();
		$fileName.text('');
		files.val('');
	}
	
	
	return {
		chooseFile : chooseFile,
		uploadFile : uploadFile
	}
})})()
