;
! function() {
	var layer = layui.layer,
		form = layui.form,
		carousel = layui.carousel;

	// 背景图片轮播
	carousel.render({
		elem: '#login_carousel',
		width: '100%',
		height: '100%',
		interval: 3000,
		arrow: 'none',
		anim: 'fade',
		indicator: 'none'
	});

	// 验证码值存储变量
	var vailCode;
	// 执行获取验证码
	//refCode();

	// 点击刷新验证码
	//$("#refCode_login_img").on("click", function() {
	//	refCode();
	//});

	// 获取验证码
	/*function refCode() {
		$.ajax({
			url: "/ssm/code/getVerifyCode",
			type: "post",
			success: function(result) {
				//vailCode = result.data.rand;
				$("#refCode_login_img").prop("src",result);
				$("#code").val("");
			}
		});
	}*/
    $("#refCode_login_img").on("click",function(){
        document.getElementById('refCode_login_img').src='/ssm/code/getVerifyCode?t='+new Date().getTime();
        $("#code").val("");
    })
	// 自定义验证规则
	form.verify({
		account: function(value) {
			var regPhone = /^1[3456789]\d{9}$/;
			if(!regPhone.test(value.trim())) {
				return "请输入正确的手机号";
			}
		},
		code: function(value) {
			if(value == ""|| value.length!=4) {
				//refCode();
				return "验证码不正确";
			}
		}
	});

	//监听提交  
	form.on("submit(login)", function() {
		$.ajax({
			url: "/ssm/login/login",
			type: "post",
            dataType:"json",
			data: {
				"account": $("#account").val(),
				"password": $("#password").val()
			},
			success: function(result) {
				if(result.status == 0) {
					location = "/ssm/book/list";
				} else {
					//refCode();
					$("#password").val("");
					layer.alert(result.msg, {
						title: '提交结果'
					});
				}
			}
		});

		return false;
	});
}();