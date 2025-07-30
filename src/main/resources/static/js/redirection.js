let secondsLeft = 5;

function updateCountdown() {
    const countdown = document.getElementById("countdown");

    countdown.textContent = secondsLeft.toString();
    secondsLeft--;

    if (secondsLeft < 0) {
        window.location.href = /*[[${'/'}]]*/ "/";
    } else {
        setTimeout(updateCountdown, 1000);
    }
}

window.onload = updateCountdown;