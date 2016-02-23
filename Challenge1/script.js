var country, state;

function setCountry() {
  var c = document.getElementById("country");
  country = c.options[c.selectedIndex].value;
}

function setState() {
  var s = document.getElementById("state");
  state = s.options[s.selectedIndex].value;
}

function submitForm() {
  var first = document.getElementById("firstName").value;
  var last = document.getElementById("lastName").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  if (!first)
  {
    document.getElementById("firstMsg").innerHTML = "First Name required";
  }
  else
  {
    document.getElementById("firstMsg").innerHTML = "";
  }
  if (country && state) {
    document.getElementById("msg").innerHTML = "Submitted successfully!";
  } else {
    document.getElementById("msg").innerHTML = "Please fill all required fields.";
  }
}

document.getElementById("country").addEventListener("change", setCountry);
document.getElementById("state").addEventListener("change", setState);
