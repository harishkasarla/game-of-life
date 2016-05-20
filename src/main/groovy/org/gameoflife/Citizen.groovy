package org.gameoflife

import com.fasterxml.jackson.annotation.JsonIgnore

class Citizen {
	
	@JsonIgnore
	List<Citizen> neighbours
	Boolean alive
	Tuple2 position
	
	Citizen(int x, int y, Boolean alive=false){
		this.alive = alive
		this.neighbours = []
		this.position = new Tuple2(x, y)
	}
	
	void live(){
		this.alive = true
	}
	
	void die(){
		this.alive = false
	}
	
	Boolean isAlive(){
		alive
	}
	
	Boolean isDead(){
		!isAlive()
	}
	
	Citizen addNeighbour(Citizen neighbour){
		neighbours << neighbour
		this
	}
	
	Boolean mustToggle(){
		def toToggle = []
		def alives = neighbours.findAll { it.isAlive() }.size()
		
		if ( isAlive() && alives < 2 ) {
			true
			
		} else if ( isAlive() && (alives == 2 || alives == 3) )  {
			false
		
		} else if ( isAlive() && alives > 3 ) {
			true
		
		} else if ( isDead() && alives == 3 ) {
			true
			
		} else {
			false
		}
	}
	
	void toggleLife(){
		this.alive = !isAlive() 
	}
	
//	String toString() {
//		isAlive() ? '[x]' : '[ ]'
//	}
	
}
