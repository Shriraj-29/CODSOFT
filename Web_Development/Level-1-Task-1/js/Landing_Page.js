const mobile_nav = document.querySelector(".mobile-navbar-btn");
const nav_header = document.querySelector(".header");

const toggleNavbar = () => {
    nav_header.classList.toggle("active");
};

mobile_nav.addEventListener("click", () => toggleNavbar());

// JavaScript to trigger animation when text comes into view
window.addEventListener('scroll', () => {
    const scrollPosition = window.scrollY;
    const elements = document.querySelectorAll('.scroll-animation');
    
    elements.forEach(el => {
      const elementPosition = el.getBoundingClientRect().top + window.scrollY;
      const isVisible = scrollPosition > elementPosition - window.innerHeight;
      el.classList.toggle("animate", isVisible);
    });
  });
