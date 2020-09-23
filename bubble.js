var list = [];
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.beginPath();
//ctx.translate(0, 550);
//ctx.scale(1, -1);
ctx.fillStyle = "black";
ctx.font="17px Verdana";

var x = 22;
for (i = 0; i < 15; i++) {
    var random = Math.floor(Math.random() * (400 - 10) + 10);
    bar = ctx.fillRect(x, 4, 50, random);
    ctx.fillText(random, x + 8, random + 25)
    list.push(random);
    x += 51;
}

async function bubbleSort() {
    for (let i = 0; i < list.length - 1; i++) {
        for (let j = 0; j < list.length - i - 1; j++) {
            const result1 = await resolve(550);
            repaint(list, j + 1);
            if (list[j] > list[j + 1]) {
                let temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                repaint(list, j + 1);
                //const result2 = await resolve(550);
            } 
        }
    }
    repaint(list, -1);
}

function resolve(delay) {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve('resolved');
      }, delay);
    });
  }

function repaint(list, index) {
    ctx.clearRect(0, 0, c.width, c.height);
    //ctx.fillStyle = "#FF0000";
    let k = 22;
    if (index != -1) {
        for (let i = 0; i < list.length; i++) {
            if (i == index) {
                ctx.fillStyle="red";
                ctx.fillRect(k, 4, 50, list[i]);
                ctx.fillText(list[i], k + 8, list[i] + 25)
            } else {
                ctx.fillStyle="black";
                ctx.fillRect(k, 4, 50, list[i]);
                ctx.fillText(list[i], k + 8, list[i] + 25)
            }
            
            k += 51;
        }
    } else {
        for (let i = 0; i < list.length; i++) {
            
            ctx.fillStyle="black";
            ctx.fillRect(k, 4, 50, list[i]);
            ctx.fillText(list[i], k + 8, list[i] + 25)
              
            k += 51;
        }
    }
    
}


