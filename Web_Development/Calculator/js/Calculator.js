let display = document.querySelector(".display");

function appendToDisplay(value) {
  if (
    display.value == "+" ||
    display.value == "-" ||
    display.value == "*" ||
    display.value == "/" ||
    display.value == "%"
  ) {
    // If the first character is an operator, remove it and add a space before appending the new value
    display.value = display.value.slice(1);
  } else {
    // Otherwise, simply append the new value to whatever's already in the display
    display.value += value;
  }
}

function clearDisplay() {
  display.value = "";
}

function back() {
  display.value = display.value.slice(0, -1);
}

function calculateResult() {
  try {
    display.value = eval(display.value);
  } catch (error) {
    display.value = "Error";
  }
}
