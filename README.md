#TicTaeToe

Strategies:
the first "whatever" bot chooses a random cell and checks if it is empty, if so, it puts a mark in it,
 otherwise it keep searching for an empty cell.

the second "clever" bot just fills all the cells starting from index (0,0) until it reaches index (size, size),
 and if faces a filled cell it skips it.

the last bot is similar to the "clever" bot but it keeps swaping in the way it fills the cells; sometimes it fills the horizontally from (0,0) to (size,size), and othertimes it 
fills vertically.

Player Interface Benefits:
 the beauty in interfaces is that i dont have to start all over again whenever i want to add a new bot,
  i dont have to have multiple playTurn() methods in my code, because this method is universal through all the bots,
   and all the bots belong to the Player interface, so i just make a new player and make it so that it implements the Player interface,
  and whenever i write playerX.playTurn for example the mathod playTurn works for every single player i have in my project, so i dont have to specify one.

  clever VS whatever || SIZE = 4, WINSTREAK = 3 :
  ######### Results #########
  Player1, clever won: 8361 rounds
  Player2, whatever won: 1638 rounds
  Ties: 1

  genius VS clever || SIZE = 4, WINSTREAK = 3 :
  ######### Results #########
  Player1, genius won: 9999 rounds
  Player2, clever won: 1 rounds
  Ties: 0

  clever VS clever || SIZE = 4, WINSTREAK = 3 :
  ######### Results #########
  Player1, clever won: 5000 rounds
  Player2, whatever won: 5000 rounds
  Ties: 1
