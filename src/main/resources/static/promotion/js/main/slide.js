var mySwiper  = new Swiper('.swiper', {
  slidesPerView: 3,
  spaceBetween: 10,
  loopAdditionalSlides: 1,
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
  scrollbar: {
    el: '.swiper-scrollbar',
    draggable: true
  }
})



// 멈추기 autoplay.stop();
// 멈추기 autoplay.start();