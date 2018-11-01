Feature: AIP exchanges in game
	
	Scenario: AIP is one card away RF and exchanges that card and wins with RF
		Given HTB draws card and AIP draws one card away RF 
		And AIP exchanges one card
		And AIP has RF
		Then AIP wins HTB
		
	Scenario: AIP is one card away RF and exchanges that card and loses without RF
		Given HTB draws card and AIP draws one card away RF from deck without RF
		And AIP exchanges one card
		And AIP does not have RF
		Then AIP loses HTB
		
	Scenario: AIP is one card away SF and exchanges that card and wins with SF
		Given HTB draws card and AIP draws one card away SF 
		And AIP exchanges one card
		And AIP has SF
		Then AIP wins HTB
		
	Scenario: AIP is one card away SF and exchanges that card and wins with SF
		Given HTB draws card and AIP draws one card away SF from deck without SF 
		And AIP exchanges one card
		And AIP does not have SF
		Then AIP loses HTB
	
	Scenario: AIP has TOK and exchanges lowest rank card and wins with FH
		Given HTB draws card and AIP draws TOK 
		And AIP exchanges one card
		And AIP has FH
		Then AIP wins HTB
		
	Scenario: AIP has TOK and exchanges lowest rank card and loses without FH
		Given HTB draws card and AIP draws TOK from deck without TOK
		And AIP exchanges one card
		And AIP does not have FH
		Then AIP loses HTB
		
	Scenario: AIP has TP and exchanges other card wins with FH
		Given HTB draws card and AIP draws TP
		And AIP exchanges one card
		And AIP has FH
		Then AIP wins HTB
		
	Scenario: AIP has TP and exchanges other card loses with TP
		Given HTB draws card and AIP draws TP from deck without FH
		And AIP exchanges one card
		And AIP has TP
		Then AIP loses HTB
		
	Scenario: AIP is one card away F and exchanges that card and wins with F
		Given HTB draws card and AIP draws one card away F 
		And AIP exchanges one card
		And AIP has F
		Then AIP wins HTB
		
	Scenario: AIP is one card away F and exchanges that card and loses without F
		Given HTB draws card and AIP draws one card away F from deck without F
		And AIP exchanges one card
		And AIP does not have F
		Then AIP loses HTB
		
	Scenario: AIP is one card away S and exchanges that card and wins with S
		Given HTB draws card and AIP draws one card away S 
		And AIP exchanges one card
		And AIP has S
		Then AIP wins HTB
		
	Scenario: AIP is one card away S and exchanges that card and wins with S
		Given HTB draws card and AIP draws one card away S from deck without S
		And AIP exchanges one card
		And AIP does not have S
		Then AIP loses HTB
		
	Scenario: AIP has three card of same suit then exchanges other two
		Given HTB draws card and AIP draws hand with three same suit
		Then AIP exchanges two card
		
	Scenario: AIP has three card in sequence then exchanges other two
		Given HTB draws card and AIP draws hand with three card in sequence
		Then AIP exchanges two card
		
	Scenario: AIP has one pair and exchanges three others
		Given HTB draws card and AIP draws hand with one pair
		Then AIP exchanges cards
		
	Scenario: AIP has no pair and exchanges three others keeping highest two
		Given HTB draws card and AIP draws hand with no pair
		Then AIP exchanges three cards