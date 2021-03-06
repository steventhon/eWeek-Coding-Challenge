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
  var re = /[^\s@]+@[^\s@]+\.[^\s@]+/;
  return re.test(email);
}

function checkPassword(password) {
  if (password.length < 8)
  {
    return false;
  }
  var nums = 0;
  for (var i = 0, len = password.length; i < len; i++) {
    if (!isNaN(password[i]))
    {
      nums++;
    }
  }
  if (nums >= 2)
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
  var comment = document.getElementById("comment").value;
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
  else if (!checkPassword(password))
  {
    document.getElementById("passwordMsg").innerHTML = "Password needs at least 8 characters, 2 need to be numbers";
  }
  else
  {
    document.getElementById("passwordMsg").innerHTML = "";
  }
  if (!comment)
  {
    document.getElementById("commentMsg").innerHTML = "Comments required";
  }
  else
  {
    document.getElementById("commentMsg").innerHTML = "";
  }
  if (!country) {
    document.getElementById("countryMsg").innerHTML = "Country required";
  }
  else
  {
    document.getElementById("countryMsg").innerHTML = "";
  }
  if (!state) {
    document.getElementById("stateMsg").innerHTML = "State required";
  }
  else
  {
    document.getElementById("stateMsg").innerHTML = "";
  }
  if (state && country && comment && checkPassword(password) && checkEmail(email) && last && first)
  {
    document.getElementById("msg").innerHTML = "Submitted successfully!";
  }
  else
  {
    document.getElementById("msg").innerHTML = "Please fill all fields";
  }
}

document.getElementById("country").addEventListener("change", setCountry);
document.getElementById("state").addEventListener("change", setState);
