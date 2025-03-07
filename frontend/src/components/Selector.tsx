import React from 'react'

function Selector() {
  const letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
  return (
  <nav>
    {letters.map(letter => (
      <a key={letter} href={`#${letter}`}>
        {letter + " - "}
      </a>
    ))}
  </nav>
  )
}

export default Selector
