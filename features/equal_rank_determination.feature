Feature: Determining winner in case of equal rank
	
	Scenario: Both AIP and HTB has RF and highest suit wins
		Given HTB draws RF and AIP draws RF
		Then Highest suit wins
		
	Scenario: Both AIP and HTB has SF with distinct highest card and then highest card wins
		Given HTB draws SF and AIP draws SF
		Then Highest card wins
		
	Scenario: Both AIP and HTB has SF with same highest card, then suit wins
		Given HTB draws SF and AIP draws SF with same highest cards
		Then Highest suit wins
		
	Scenario: Both AIP and HTB has FOK then highest card of quadruplet wins
		Given HTB draws FOK and AIP draws FOK
		Then Highest quadruplet wins
	
	Scenario: Both AIP and HTB has FH then highest card of triplet wins
		Given HTB draws FH and AIP draws FH
		Then Highest triplet wins
		
	Scenario: Both AIP and HTB has TOK then highest card of triplet wins
		Given HTB draws TOK and AIP draws TOK
		Then Highest triplet wins
		
	Scenario: Both AIP and HTB has S with same rank then highest suit wins
		Given HTB draws S and AIP draws S
		Then Highest suit of highest card wins
		
	Scenario: Both AIP and HTB has S with different rank then highest card wins
		Given HTB draws S and AIP draws S with different rank
		Then Highest card wins
		
	Scenario: Both AIP and HTB has TP with same highest rank then highest suit wins
		Given HTB draws TP and AIP draws TP with same highest rank
		Then Highest suit of two pair wins
		
	Scenario: Both AIP and HTB has TP with different highest rank then highest pair wins
		Given HTB draws TP and AIP draws TP with different highest rank
		Then Highest card of two pair wins
		
	
	Scenario: Both AIP and HTB has OP with equal rank then highest suit wins
		Given HTB draws OP and AIP draws OP with equal rank
		Then Highest suit of pair wins	
		
	Scenario: Both AIP and HTB has OP with distinct rank then highest rank and highest suit wins
		Given HTB draws OP and AIP draws OP with distinct rank
		Then Highest rank of pair wins	
	
	Scenario: Both AIP and HTB has HC with same rank then highest suit wins
		Given HTB draws HC and AIP draws HC with same rank
		Then Highest suit of highest rank wins
	
	Scenario: Both AIP and HTB has HC with distinct rank then highest rank and highest suit wins
		Given HTB draws HC and AIP draws HC with distinct rank
		Then Highest suit and highest rank wins
	
	Scenario: Both AIP and HTB has F with same rank then highest suit wins
		Given HTB draws F and AIP draws F with same rank
		Then Highest suit wins
		
	Scenario: Both AIP and HTB has F with four same rank then highest rank of fifth wins
		Given HTB draws F and AIP draws F with four same rank
		Then Highest suit highest rank of fifth wins
		
	Scenario: Both AIP and HTB has F with three same rank then highest rank four remaining wins
		Given HTB draws F and AIP draws F with three same rank
		Then highest rank of four remaining wins
		
	Scenario: Both AIP and HTB has F with two same rank then highest rank six remaining wins
		Given HTB draws F and AIP draws F with two same rank
		Then highest rank of six remaining wins
		
	Scenario: Both AIP and HTB has F with one same rank then highest rank eight remaining wins
		Given HTB draws F and AIP draws F with one same rank
		Then highest rank of eight remaining wins