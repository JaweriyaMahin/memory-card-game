const board = document.getElementById("board")

let cards = ["A","A","B","B","C","C","D","D"]
cards.sort(()=>0.5-Math.random())

let firstCard = null
let secondCard = null
let score = 0
let time = 0

setInterval(()=>{
time++
document.getElementById("time").innerText=time
},1000)

cards.forEach(symbol=>{
let card = document.createElement("div")
card.classList.add("card")
card.dataset.value = symbol
card.innerText = "?"

card.addEventListener("click",function(){

if(card.classList.contains("flipped")) return

card.innerText = symbol
card.classList.add("flipped")

if(!firstCard){
firstCard = card
}
else{
secondCard = card

if(firstCard.dataset.value === secondCard.dataset.value){
score++
document.getElementById("score").innerText = score
firstCard=null
secondCard=null
}
else{
setTimeout(()=>{
firstCard.innerText="?"
secondCard.innerText="?"
firstCard.classList.remove("flipped")
secondCard.classList.remove("flipped")
firstCard=null
secondCard=null
},800)
}

}

})

board.appendChild(card)

})