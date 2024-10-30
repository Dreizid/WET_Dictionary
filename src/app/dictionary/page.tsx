import React from 'react'
import { Section } from '@/components/Section';

export default async function DictionaryPage() {
  const res = await fetch("http://localhost:8080/sorted/waray");
  const data = await res.json();

  return (
    <div>
      {Object.entries(data).map(([key , value]) => (
      <Section letter={key} words={value} />
      ))}
    </div>
  )
}
