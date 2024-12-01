$(this).ready(function () {
    if ($.fn.slick) {
        $('.slider-image').slick({
            dots: false,
            arrows: false,
            fade: true,
            fadeSpeed: 1000,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 5000
        });

        var slickOptions = {
            dots: false,
            arrows: false,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 5000
        }

        $('#top-slider').slick(slickOptions);
    } else {
        console.error('Slick is not loaded');
    }
});

document.addEventListener("DOMContentLoaded", function () {
    const lazyloadImages = document.querySelectorAll("img.lazyload");

    lazyloadImages.forEach(img => {
        const tempImg = new Image();
        tempImg.src = img.dataset.src;

        tempImg.onload = function () {
            img.src = img.dataset.src;
        };

        tempImg.onerror = function () {
            console.error(`Error loading image: ${img.dataset.src}`);
        };
    });
});

document.addEventListener("DOMContentLoaded", function () {
    function animateValue(id, start, end, duration) {
        const obj = document.getElementById(id);
        const range = end - start;
        const minTimer = 50;
        const stepTime = Math.abs(Math.floor(duration / range));

        const startTime = new Date().getTime();
        const endTime = startTime + duration;
        let timer;

        function formatNumberWithCommas(number) {
            return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }

        function run() {
            const now = new Date().getTime();
            const remaining = Math.max((endTime - now) / duration, 0);
            const value = Math.round(end - (remaining * range));
            obj.innerHTML = formatNumberWithCommas(value);
            if (value === end) {
                clearInterval(timer);
            }
        }

        timer = setInterval(run, Math.max(stepTime, minTimer));
        run();
    }

    function handleIntersection(entries, observer) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const area = entry.target;
                area.classList.remove('hidden-area');
                area.classList.add('visible-area');

                if (area.classList.contains('stat-area')) {
                    const totalLapsElement = document.getElementById("total-laps");
                    const totalDriversElement = document.getElementById("total-drivers");
                    const totalRacesElement = document.getElementById("total-races");

                    const totalLaps = parseInt(totalLapsElement.getAttribute('data-value').replace(/,/g, ""));
                    const totalDrivers = parseInt(totalDriversElement.getAttribute('data-value').replace(/,/g, ""));
                    const totalRaces = parseInt(totalRacesElement.getAttribute('data-value').replace(/,/g, ""));

                    animateValue("total-laps", 0, totalLaps, 2000);
                    animateValue("total-drivers", 0, totalDrivers, 2000);
                    animateValue("total-races", 0, totalRaces, 2000);
                }

                observer.unobserve(area);
            }
        });
    }

    const options = {
        root: null,
        rootMargin: '0px',
        threshold: 0.1
    };

    const statObserver = new IntersectionObserver(handleIntersection, options);
    statObserver.observe(document.querySelector('.stat-area'));

    const eventObserver = new IntersectionObserver(handleIntersection, options);
    eventObserver.observe(document.querySelector('.event-area'));
});