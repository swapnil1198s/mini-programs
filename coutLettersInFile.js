//This program returns a object with letters and the number of times they appear in the input

const fs = require('fs');
const { resolve } = require('path');
countLetters = async (name)=>{
    name = name.toLowerCase();
    var map = new Map();
    for(letter of name){
        if(map.has(letter)){
            map.set(letter, map.get(letter)+1);
        }
        else{
            map.set(letter, 1);
        }
    }
    const obj = Object.fromEntries(map);
    //console.log(obj);
    return obj;
}

readText = async (fileName)=>{
        fs.readFile(fileName, async (err, data)=>{
            if(err){
                throw "Something went wrong";
            }
            let obj = await countLetters(data.toString());
            console.log(obj);
        })
}

//function call with input file
readText('input.txt')