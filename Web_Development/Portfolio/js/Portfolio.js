document.addEventListener("DOMContentLoaded", function () {
  // ============================================
  // Creating a Responsive Navbar Component
  // ============================================

  const mobileNav = document.querySelector(".mobile-nav-btn");
  const navbar = document.querySelector(".navbar");

  mobileNav.addEventListener("click", () => {
    navbar.classList.toggle("active");
  });

  // ============================================
  // Creating a Portfolio Tabbed Component
  // ============================================
  const pBtns = document.querySelector(".p-btns");
  const pBtn = document.querySelectorAll(".p-btn");
  const pImgElem = document.querySelectorAll(".img-overlay");

  pBtns.addEventListener("click", (e) => {
    const pBtnClicked = e.target;

    if (!pBtnClicked.classList.contains("p-btn")) {
      pBtn.forEach((curElem) => {
        curElem.classList.remove("p-btn-active");
      });

      pImgElem.forEach((curElem) => {
        curElem.classList.remove("p-img-not-active");
        curElem.classList.add("p-img-active");
      });
      return;
    }

    pBtn.forEach((curElem) => {
      curElem.classList.remove("p-btn-active");
    });

    pBtnClicked.classList.add("p-btn-active");

    const btnNum = pBtnClicked.dataset.btnNum;
    const imgActive = document.querySelectorAll(`.p-btn--${btnNum}`);

    pImgElem.forEach((curElem) => {
      curElem.classList.remove("p-img-active");
      curElem.classList.add("p-img-not-active");
    });

    imgActive.forEach((curElem) => {
      curElem.classList.remove("p-img-not-active");
    });
  });

  // ============================================
  // Initialize Swiper
  // ============================================
  const initializeSwiper = () => {
    const swiperOptions = {
      slidesPerView: window.innerWidth < 800 ? 1 : 2,
      spaceBetween: 30,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      autoplay: {
        delay: 2500,
        disableOnInteraction: false,
      },
    };
    new Swiper(".mySwiper", swiperOptions);
  };

  initializeSwiper();
  window.addEventListener("resize", initializeSwiper);

  // ============================================
  //Scroll to Top Button
  // ============================================
  const scrollElem = document.createElement("div");
  const footerElem = document.querySelector(".section-footer");
  const heroSectiion = document.querySelector(".section-hero");

  scrollElem.classList.add("scrollTop-style");
  scrollElem.innerHTML = `<ion-icon name="arrow-up-outline" class="scroll-top"></ion-icon>`;

  footerElem.after(scrollElem);

  const scrollTop = () => {
    heroSectiion.scrollIntoView({ behavior: "smooth" });
  };

  scrollElem.addEventListener("click", scrollTop);

  // ============================================
  // Animate Number Counter
  // ============================================
  const counterNum = document.querySelectorAll(".counter-numbers");
  speed = 200;

  const animateCounter = (curElem) => {
    const targetNum = parseInt(curElem.dataset.number);
    let currentNum = parseInt(curElem.innerText);
    const increment = Math.ceil(targetNum / speed);

    const updateCounter = () => {
      if (currentNum < targetNum) {
        currentNum = Math.min(targetNum, currentNum + increment);
        curElem.innerText = `${currentNum.toLocaleString()}+`;
        requestAnimationFrame(updateCounter);
      }
    };

    updateCounter();
  };

  counterNum.forEach((curElem) => {
    animateCounter(curElem);
  });

  // ============================================
  // Lazy Loading Images
  // ============================================
  const imgRef = document.querySelectorAll("img[data-src]");

  const lazyLoadImages = () => {
    const imgObserver = new IntersectionObserver((entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          const img = entry.target;
          img.src = img.dataset.src;
          imgObserver.unobserve(img);
        }
      });
    });

    imgRef.forEach((img) => {
      imgObserver.observe(img);
    });
  };

  lazyLoadImages();
});
