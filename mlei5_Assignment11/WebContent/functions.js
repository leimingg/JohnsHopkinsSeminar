$(document).ready(function() {
	
	$(".remove").click(function() {
		$.ajax({
			url: "remove",
			data: "course=" + $(this).attr("value"),
			type: "POST",
			success: function() {
				window.location.href = window.location.href;
			}
		});
	});	
});