
function showErrorToast(message) {
	$.toast({
		heading : 'Sorry!!!',
		text : message,
		showHideTransition : 'slide',
		icon : 'error',
		loaderBg : '#f2a654',
		position : 'top-right'
	})
}