/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){

function iniciar() {
    var map_canvas = document.getElementById('map');
    var mapOptions = {
      center: new google.maps.LatLng(13.9709564, -89.5748148),
      zoom: 17,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(map_canvas,mapOptions);
    }
     google.maps.event.addDomListener(window, 'load', iniciar);
});

