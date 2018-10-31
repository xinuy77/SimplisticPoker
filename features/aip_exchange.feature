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