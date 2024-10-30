"use client";
import React, { useEffect, useState } from "react";
import { SearchBar } from "@/components/SearchBar";
import { WordCardHome } from "@/components/WordCardHome";
import Link from "next/link";

export default function Home() {
  const API_URL = "http://localhost:8080/search/";
  const [result, setResult] = useState<any[]>([]);
  const [isEmpty, setIsEmpty] = useState<boolean>(true);

  useEffect(() => {
    console.log(result);
  }, [result])
  return (
    <div className="flex justify-center flex-col items-center ">
      <div className="my-16">
        <h1 className="text-white text-6xl font-bold">Waray Dictionary</h1>
        <h2>Waray • English • Tagalog</h2>
      </div>
      <SearchBar
        onResult={setResult}
        isEmpty={setIsEmpty}
        apiUrl={API_URL}
        debounceDelay={150}
        placeholder="Search..."
        className="bg-slate-500 rounded-3xl pl-10 pr-4 py-2 text-xl w-[400px] shadow-xl text-white"
      />
      {!isEmpty &&
        ((result.length > 0) ? (result.map((entry) => (<WordCardHome entry={entry}></WordCardHome>))) : <div>No results found</div>)
      }
      <Link href="/dictionary" className="bg-slate-500 text-white px-4 py-2 my-8 rounded-md shadow-md">Dictionary</Link> 
    </div>
  );
}
