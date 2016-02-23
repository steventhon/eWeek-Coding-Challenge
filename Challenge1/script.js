var country, state;

function setCountry() {
  var m = document.getElementById("country");
  manufacturer = m.options[m.selectedIndex].value;
}

function setState() {
  var s = document.getElementById("state");
  state = s.options[s.selectedIndex].value;
}

function submit() {
  if (country && state) {
    document.getElementById("msg").innerHTML = "Submitted successfully!";
  } else {
    document.getElementById("msg").innerHTML = "Please fill all required fields.";
  }
}

document.getElementById("country").addEventListener("change", setCountry);
document.getElementById("state").addEventListener("change", setState);
