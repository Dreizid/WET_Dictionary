
import React from 'react'

interface Entry {
  waray: String;
  english: String;
  tagalog: String;
}

type WordCard = {
  entry: Entry;
}
export const WordCardHome = ({ entry }: WordCard) => {
  return (
    <div className="grid grid-cols-2 grid-rows-1 gap-4 mb-4 mt-8 rounded-2xl bg-slate-900 shadow-xl w-[36rem]">
      <div className='flex items-center flex-col col-span-2 mt-4 mb-2'>
        <h1 className='font-bold text-2xl text-[var(--secondary-foreground-color)]'>{entry.waray}</h1>
        <h2 className="text-xs text-white">Waray</h2>
      </div>
      <div className='flex flex-col mx-8 mb-8 mr-4 p-2 rounded-lg bg-[var(--field-color)]'>
        <h1 className='text-xs text-white'>English</h1>
        <h2 className='text-xl text-white'>{entry.english}</h2>
      </div>
      <div className='flex flex-col mx-8 mb-8 ml-4 p-2 rounded-lg bg-[var(--field-color)]'>
        <h1 className='text-xs text-white'>Tagalog</h1>
        <h2 className='text-xl text-white'>{entry.tagalog}</h2>
      </div>
    </div>
  )
}
