var list = [];
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.beginPath();

var x = 4;
for (i = 0; i < 38; i++) {
    var random = Math.floor(Math.random() * (400 - 10) + 10);
    bar = ctx.fillRect(x, 4, 20, random);
    list.push(random);
    x += 21;
}

async function bubbleSort() {
    for (let i = 0; i < list.length - 1; i++) {
        for (let j = 0; j < list.length - i - 1; j++) {
            if (list[j] > list[j + 1]) {
                let temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                repaint(list);
                const result = await resolve();
            }
        }
    }
}

function resolve() {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve('resolved');
      }, 200);
    });
  }

function repaint(list) {
    ctx.clearRect(0, 0, c.width, c.height);
    //ctx.fillStyle = "#FF0000";
    let k = 4;
    for (let i = 0; i < 38; i++) {
        ctx.fillRect(k, 4, 20, list[i]);
        k += 21;
    }
}


