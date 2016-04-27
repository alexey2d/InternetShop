// $(document).ready(function () {
//
//     var location = document.location.href;
//     var last = location.length - 1;
//     var result = location.charAt(last);
//
//     if (found = result) {
//         $('#select_id').val(found);
//     }
//
//     $('#select_id').on("change", function () {
//         var myTag = $("#select_id :selected").val();
//         // var url = '/product/getAll' + myTag;
//         var url = '/product/getAll?sort=' + myTag;
//         $.ajax({
//             url: url,
//             type: 'GET',
//             success: function (response) {
//                 document.location.href = url;
//             }
//         });
//     });
// });

$(document).ready(function () {
    if (found = document.location.href.match(/sort=([^&$]+)/i)) {
        $('#sorted').val(found[1]);
    }

    $('#sorted').on('change', function () {
        document.location.href = replaceUrlParam(document.location.href, 'sort', $(this).val());
    })

    function replaceUrlParam(url, paramName, paramValue) {
        var pattern = new RegExp('\\b(' + paramName + '=).*?(&|$)')
        if (url.search(pattern) >= 0) {
            return url.replace(pattern, '$1' + paramValue + '$2');
        }
        return url + (url.indexOf('?') > 0 ? '&' : '?') + paramName + '=' + paramValue

    }

})