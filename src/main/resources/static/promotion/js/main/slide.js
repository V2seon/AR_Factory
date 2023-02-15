var mySwiper  = new Swiper('.swiper', {
  autoplay: {
    delay: 5000,
    disableOnInteraction: false
  },
  loop: true,
  slidesPerView: 1,
  spaceBetween: 0,
  centeredSlides: true,
  loopAdditionalSlides: 1,
  pagination: {
    el: '.swiper-pagination',
    clickable: true
  }
})



// 멈추기 autoplay.stop();
// 멈추기 autoplay.start();