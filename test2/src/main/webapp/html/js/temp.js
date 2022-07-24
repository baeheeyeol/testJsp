function copyWrite() {
    let outputText = document.querySelector("#outputText")
    let inputText = document.querySelector("#inputText").value

    outputText.setAttribute('srcdoc', inputText)
    console.log(inputText)
}