import React from "react";
import { WordCard } from "./WordCard";

interface SectionProps {
  words: any[];
  letter: string;
}
export const Section = ({ words, letter }: SectionProps) => {
  return (
    <div className="m-12" id={letter}>
      <h2 className="text-white my-4 mx-4 text-8xl">{letter}</h2> 
      <div className="grid grid-cols-2">
        {words.map((word) => (
          <WordCard entry={word} />
        ))}
      </div>
    </div>
  );
};
