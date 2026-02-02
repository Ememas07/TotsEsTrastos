teams = document.getElementsByClassName("card mb-0 shadow-none h-100")
function test() {
    for (let index = 0; index < teams.length; index++) {
        const element = teams[index]
        cars = document.querySelectorAll("h6")
        teamRatings = document.querySelectorAll("span[data-bs-original-title]")
        rating = document.getElementsByClassName("badge bg-info rounded text-dark")
        console.log(cars[index].innerHTML + " Rating: " + teamRatings[index].innerHTML)
    }
}
