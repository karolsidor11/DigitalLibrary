function getTime() {
    return (new Date()).toLocaleTimeString();
}

document.getElementById('time').innerHTML = getTime();
setInterval(function () {
    document.getElementById('time').innerHTML = getTime();
}, 1000);
