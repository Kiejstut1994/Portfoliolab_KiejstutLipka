
const btn=document.querySelector("#wyniki")

btn.addEventListener("click", function(event) {
    const worki=document.querySelector("#worki")
    const instytucja=document.querySelector("#instytucja")
    const adres=document.querySelector("#adress")
    const termin=document.querySelector("#termin")

    const kategoria=document.querySelectorAll(".category")
    const quantity=document.querySelector("#quantity")
    const instytution=document.querySelectorAll(".institution")
    const street=document.querySelector("#street")
    const city=document.querySelector("#city")
    const zipcod=document.querySelector("#zipcod")
    const phone=document.querySelector("#phone")
    const date=document.querySelector("#date")
    const time=document.querySelector("#time")
    const pickUpComment=document.querySelector("#pickUpComment")


    let kategoriawybrana=new Array()
    kategoria.forEach(function(element) {
        if (element.checked)
        {
            kategoriawybrana.push(element.title)
        }
    });
    let wynikowekate=kategoriawybrana.join(",")
    worki.innerHTML=quantity.value+" "+wynikowekate

    let institution=null
    instytution.forEach(function(element) {
        if (element.checked)
        {
            institution=element.title
        }
    });
    instytucja.innerHTML=institution
    const li1=document.createElement("li");
    const li2=document.createElement("li");
    const li3=document.createElement("li");
    const li4=document.createElement("li");
    li1.innerText=street.value
    li2.innerText=city.value
    li3.innerText=zipcod.value
    li4.innerText=phone.value
    adres.appendChild(li1)
    adres.appendChild(li2)
    adres.appendChild(li3)
    adres.appendChild(li4)
    const li5=document.createElement("li");
    const li6=document.createElement("li");
    const li7=document.createElement("li");
    li5.innerText=date.value
    li6.innerText=time.value
    li7.innerText=pickUpComment.value
    termin.appendChild(li5)
    termin.appendChild(li6)
    termin.appendChild(li7)
});