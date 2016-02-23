var country, state;

function setCountry() {
  var c = document.getElementById("country");
  country = c.options[c.selectedIndex].value;
}

function setState() {
  var s = document.getElementById("state");
  state = s.options[s.selectedIndex].value;
}

function checkEmail(email) {
  if (email.length() > 3)
  {
    return true;
  }
  else
  {
    return false;
  }
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
  if (!last)
  {
    document.getElementById("lastMsg").innerHTML = "Last Name required";
  }
  else
  {
    document.getElementById("lastMsg").innerHTML = "";
  }
  if (!email)
  {
    document.getElementById("emailMsg").innerHTML = "Email required";
  }
  else if (!checkEmail(email))
  {
    document.getElementById("emailMsg").innerHTML = "Invalid Email";
  }
  else
  {
    document.getElementById("emailMsg").innerHTML = "";
  }
  if (!password)
  {
    document.getElementById("passwordMsg").innerHTML = "Password required";
  }
  else if (password.length() < 8)
  {
    document.getElementById("passwordMsg").innerHTML = "Password needs at least 8 characters";
  }
  else
  {
    document.getElementById("passwordMsg").innerHTML = "";
  }
  if (country && state) {
    document.getElementById("msg").innerHTML = "Submitted successfully!";
  } else {
    document.getElementById("msg").innerHTML = "Please fill all required fields.";
  }
}

document.getElementById("country").addEventListener("change", setCountry);
document.getElementById("state").addEventListener("change", setState);
