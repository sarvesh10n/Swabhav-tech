
(function(){
 document.getElementById("slider1").addEventListener('input', createButtons);
//    .addEventListener("input", createButtons);

    function createButtons() {
        var buttonBox = document.getElementById("button-box").innerHTML = " ";

        for (var i = 1; i <= this.value; i++) {
            var btn = document.createElement("BUTTON");
            var txtBtn = document.createTextNode(i);
            btn.value=i;
            btn.addEventListener('click',function(){
                console.log(this.value);
            });
            btn.appendChild(txtBtn);
            document.getElementById("button-box").appendChild(btn);

        }
    }
})();
