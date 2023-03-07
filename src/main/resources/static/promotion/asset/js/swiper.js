$(document).ready(function(){
	var swiper = new Swiper(".review-bottom .swiper-container", {
		loop: true,
		slidesPerView: 2,
		spaceBetween: 10,
		observer: true,
		observeParents: true,
		autoplay: {
			delay: 2500,
			disableOnInteraction: false,
		},
		navigation: {
			nextEl: ".review-bottom .swiper-button-next",
			prevEl: ".review-bottom .swiper-button-prev",
		},
		breakpoints: {
			991: {
				slidesPerView: 3,
			},
			767: {
				slidesPerView: 1.5,
			},
        },
	});

	var swiper2 = new Swiper(".tab-image .swiper-container", {
		//loop: true,
		slidesPerView: 'auto',
		freeMode: true,
		observer: true,
		observeParents: true,
	});
});