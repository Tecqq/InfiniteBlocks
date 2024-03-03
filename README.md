# A free highly configurable 1.8-1.20 spigot plugin allowing you to make blocks infinite for a configurable price.

Configuration:
```
nopermission: "&6You do not have permission to run this command."
playernotfound: "&cCould not find specified player."
helpmessage:
  - "&c&lInfiniteBlocks Help &7(Page 1/1)"
  - " "
  - "&c&lCommands:"
  - "&e/infiniteblocks help &8- &7View this help menu."
  - "&e/infiniteblocks give (player) (identifier) (amount) &8- &7Give a player an infinite block."

infiniteblocks:
  obsidian: # the identifier for the item use /infiniteblocks give (player) (identifier) (amount) in this case /infiniteblocks give tecana obsidian 1
    displayname: "&5&lObsidian" # the custom displayname for the item
    lore: # the custom lore for the item
      - "&5&lObsidian"
      - "&5&lObsidian"
      - "&5&lObsidian"
    itemmaterial: BEDROCK # the item that is given to the player
    placedmaterial: OBSIDIAN # the item that gets placed
    cost: 50.0 # the amount to charge the player upon placement
    message: "&c-$50" # the message to send to the player upon placement
    insufficentfundsmessage: "&4You do not have enough funds to use this"
    enchanted: true
  netherrack:
    displayname: "&c&lNetherrack"
    lore:
      - "&c&lNetherrack"
      - "&c&lNetherrack"
      - "&c&lNetherrack"
    itemmaterial: NETHERRACK
    placedmaterial: NETHERRACK
    cost: 15.0
    message: "&c-$15"
    insufficentfundsmessage: "&4You do not have enough funds to use this"
    enchanted: true
  cobblestone:
    displayname: "&7&lCobblestone"
    lore:
      - "&7&lCobblestone"
      - "&7&lCobblestone"
      - "&7&lCobblestone"
    itemmaterial: COBBLESTONE
    placedmaterial: COBBLESTONE
    cost: 30.0
    message: "&c-$30"
    insufficentfundsmessage: "&4You do not have enough funds to use this"
    enchanted: false

    # you can create as many blocks as you'd like just paste it here and configure it to your liking
```
