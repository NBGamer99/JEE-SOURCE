// If the length of the element's string is 0 then display helper message
function required(x)
{
    if (x.length == 0)
    {
        return false;
    }
    return true;
}



// Get the input field element
const submitBtn = document.getElementById("submit");
const inputFields = document.querySelectorAll(".input-field");
const errorMsg = document.getElementById("error-msg");

// Listen for changes to the input field
let error = false;
submitBtn.addEventListener("mouseover", (button)=>{


    for(inputfield of inputFields)
    {
        error = false;
        // Get the current value of the input field
        const value = inputfield.value;
        console.log(value);
        // Check if the value is a valid integer
        if (value == "") {
            errorMsg.style.animation = "fadeIn 1s forwards";
            // console.log(value +"   "+ isNaN(""));
            button.target.classList.toggle("move");
            error = true;
            break;
        }
    }
});

submitBtn.addEventListener("mouseout", (event) =>{
    if(error == true)
    {
        setTimeout(() => {
            errorMsg.style.animation="fadeOut 1s ";
            error = false;
        }, 5000);
    }
});