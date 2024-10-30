import React, { useEffect, useState } from "react";
import { CustomDiv } from "./CustomDiv";
import { CustomButton } from "./CustomButton";
import { FaSearch } from "react-icons/fa";

{
  /*onResult - takes in a function () that returns void => void, function takes 1 param with type of any*/
}
type SearchBarProps = {
  onResult: (results: any[]) => void;
  isEmpty: (isEmpty: boolean) => void;
  apiUrl?: string;
  debounceDelay?: number;
  className?: string;
  placeholder: string;
};

export const SearchBar = ({
  className,
  placeholder,
  debounceDelay = 300,
  apiUrl = "http://localhost:8080/search/",
  isEmpty,
  onResult,
}: SearchBarProps) => {
  const [query, setQuery] = useState("");
  const [debouncedQuery, setDebouncedQuery] = useState(query);

  useEffect(() => {
    const handler = setTimeout(() => setDebouncedQuery(query), debounceDelay);

    {/*This return statement runs when the component unmounts or just before the effect runs again*/}
    return () => clearTimeout(handler);
  }, [query, debounceDelay]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`${apiUrl}${debouncedQuery}`);
        const data = await response.json();

        onResult(data);
      } catch (error) {
        console.error("Error fetching data: ", error);
      }
    };

    if (debouncedQuery) {
      fetchData();
    }     

  }, [debouncedQuery, onResult, apiUrl]);

  useEffect(() => {
    query ? isEmpty(false) : isEmpty(true);
  }, [query])

  return (
    <div className="relative">
      <span className="absolute inset-y-0 left-0 flex items-center pl-3">
        <FaSearch className="text-gray-400" />
      </span>
      <input
        className={className}
        placeholder={placeholder}
        onChange={(e) => setQuery(e.target.value)}
      />
    </div>
  );
};
