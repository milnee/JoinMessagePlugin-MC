# JoinMessage Minecraft Plugin

## 🌟 Overview

JoinMessage is a lightweight and customizable Minecraft Spigot/Paper plugin that allows server administrators to create personalized join messages for players. Easily configure welcome messages with color codes and placeholders.

## ✨ Features

- 🎨 Fully customizable join messages
- 🌈 Support for color codes
- 🔧 Easy configuration
- 📝 Player name placeholders
- 🚫 Toggle join messages per player

## 🖥️ Requirements

- Minecraft Server running Spigot or Paper
- Java 8 or higher

## 🚀 Installation

1. Download the latest JAR file from the [Releases](../../releases) section
2. Place the JAR in your server's `plugins` folder
3. Restart the server or reload plugins

## 🛠️ Configuration

Edit the `config.yml` file in the plugin's folder to customize join messages:

```yaml
messages:
  joinmessage: true
  join:
    - "&7--------------------------------"
    - "&aWelcome, &f{player}&a to the server!"
    - "&7--------------------------------"
```

### Placeholders
- `{player}`: Replaced with the player's Minecraft username

### Color Codes
Use Minecraft color codes with `&` prefix:
- `&a`: Green
- `&f`: White
- `&7`: Gray

## 🎮 Commands

- `/joinmessage`: Toggle join messages for yourself
  - Requires permission: `joinmessage.command`
- `/joinmessagereload`: Reload plugin configuration
  - Requires permission: `joinmessage.reload`

## 🤝 Permissions

- `joinmessage.command`: Allows players to toggle their join messages
- `joinmessage.reload`: Allows reloading the plugin configuration

## 🐛 Reporting Issues

Found a bug? Please open an [issue](../../issues) with:
- Detailed description
- Server software and version
- Plugin version
- Steps to reproduce

## 🌐 Links

- 🌍 Website: https://millen.dev
- 💬 Discord: https://discord.gg/test
- 🐱 GitHub: https://github.com/milnee

## 📋 Upcoming Features

- [ ] More advanced placeholders
- [ ] Custom join sound
- [ ] Per-group join messages

## 🤖 Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

[Specify your license here - e.g., MIT License]

## 👨‍💻 Author

**Millen Singh**
- Email: singh-m21@ulster.ac.uk
- GitHub: [@milnee](https://github.com/milnee)

---

**Happy Server Hosting! 🎮✨**
