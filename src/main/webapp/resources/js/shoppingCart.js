$(document).ready(function () {

    $('.add2cart').on("click", function () {
        var id_prod = $(this).data('product-id');
        $.ajax({
            url: '/cart/product/' + id_prod,
            dataType: 'JSON',
            type: 'GET',
            success: function (response) {
                $('#totalCost').html(response.totalCost);
                $('#totalAmount').html(response.totalAmount);

                // alert( "Всего добавлено товаров: " + response.totalAmount + "   На сумму: " + response.totalCost);
            }
        });

    });

    $('.deleteFromCart').on("click", function () {
        var id_prod = $(this).data('product-id');
        // alert("Product id: " + id_prod);
        $.ajax({
            url: '/cart/delete/' + id_prod,
            // dataType: 'JSON',
            type: 'POST',
            success: function () {
                document.location.reload();
            }
        });

    });
});