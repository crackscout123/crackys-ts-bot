#  crackys-ts-bot
![Build Status](https://img.shields.io/github/issues/getPoland/crackys-ts-bot.svg?style=flat-square) ![Build Stars](https://img.shields.io/github/stars/getPoland/crackys-ts-bot.svg?style=flat-square) ![GitHub forks](https://img.shields.io/github/forks/getPoland/crackys-ts-bot?style=flat-square) ![Build License](https://img.shields.io/github/license/getPoland/crackys-ts-bot.svg?style=flat-square)

This is  **CrackysBot**. A very useful and administrative TeamSpeak³-Query bot.

## Dependencies

- <a href="https://www.oracle.com/de/java/technologies/javase/javase8-archive-downloads.html">JavaSE-1.8</a> (Should also work with newer versions)
- <a href="https://github.com/TheHolyWaffle/TeamSpeak-3-Java-API">TeamSpeak 3 API</a> v1.0.14 

## Table of Contents 

- [Installation](#installation)
- [Setup](#setup)
- [Contributing](#contributing)
- [License](#license)

## Installation

- Download as Zip or clone this repository.
- Download and install Java.

### Setup
First you need to run the bot in **dry-run mode** to create the config.app
```shell
$ java -jar carckysbot.jar --dry-run
```
 Edit the **config.app** to your preferences & save.
```app
host=localhost
query=serveradmin
password=password
channels=7,50
groups=9,18
nickname=CrackysBot v1
```
Replace **queryusername**, **querypassword**, **hostname** with the serverquery login credentials

After that just run the bot.
```shell
$ java -jar carckysbot.jar 
```

## Contributing

> To get started...

### Step 1

- **Option 1**
    - 🍴 Fork this repo!

- **Option 2**
    - 👯 Clone this repo to your local machine using `https://github.com/getPoland/crackys-ts-bot.git`

### Step 2

- **HACK AWAY!** 🔨🔨🔨

### Step 3

- 🔃 Create a new pull request using <a href="https://github.com/getPoland/crackys-ts-bot/compare/" target="_blank">`https://github.com/getPoland/crackys-ts-bot/compare/`</a>.


## License

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2021 © <a href="https://crackscout123.de" target="_blank">crackscout123</a>.
