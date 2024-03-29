


#  CrackysBot
![GitHub issues](https://img.shields.io/github/issues/getPoland/crackys-ts-bot?style=flat-square) ![Build Stars](https://img.shields.io/github/stars/getPoland/crackys-ts-bot.svg?style=flat-square) ![GitHub forks](https://img.shields.io/github/forks/getPoland/crackys-ts-bot?style=flat-square) ![Build License](https://img.shields.io/github/license/getPoland/crackys-ts-bot.svg?style=flat-square)

This is  **CrackysBot**. A very useful and administrative TeamSpeak³-Query bot.

## Dependencies

- <a href="https://www.oracle.com/de/java/technologies/javase/javase8-archive-downloads.html">JavaSE-1.8</a> (Should also work with newer versions)
- <a href="https://github.com/TheHolyWaffle/TeamSpeak-3-Java-API">TeamSpeak 3 API</a> v1.0.14 

## Functions 
- [**Channel Alert/Monitor**](https://github.com/getPoland/crackys-ts-bot/wiki/ChannelAlert)  - Define which channels should be monitored and which groups should be notified when someone joins on of those channels.

- [**AfkMover**](https://github.com/getPoland/crackys-ts-bot/wiki/AfkMover)  - Define a duration in minutes after which an afk user is moved to the afk channel. 

-  [**AntiRecord**](https://github.com/getPoland/crackys-ts-bot/wiki/AntiRecord)  -  Allow / Disallow users to record everywhere. Make channels / groups to allow recording.
## Todo

 -  ~~Configurable messages~~
 -  ~~Channel Alert~~
 -  ~~AfkMover~~
 -  ~~Anti-Record~~
 -  Verify-System
 - Troll-Features ? 
 - WebHook ?
 - [AdminPanel (HTML & php) ?


> Im coding this bot on my own. If you want to improve it or to add additional functions dont hesitat to [Fork / Contribut](#contributing) it or to contact me on Discord. (lostares_#6834)

## Table of Contents 

- [Installation](#installation)
- [Setup](#setup)
- [Contributing](#contributing)
- [License](#license)

## Installation

- Download the [latest relase](https://github.com/getPoland/crackys-ts-bot/releases)
- Download and install Java.

### Setup
Run the bot as following:
```shell
$ java -jar carckysbot.jar --dry-run
```
The bot will create a config.app file and exit.
```app
password=password
query=test
host=localhost
nickname=CrackysBot v1
```
Edit the **config.app** to your preferences & save. **queryusername**, **querypassword**, **hostname** with the serverquery login credentials.

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
- Copyright 2021-2022 © <a href="https://crackscout123.de" target="_blank">crackscout123</a>.
