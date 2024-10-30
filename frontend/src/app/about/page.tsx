"client component"
import React from "react";

export default function About() {
  return (
    <div className="mx-4 p-4 bg-[var(--primary-color)] text-[var(--foreground-color)]">
      <h1 className="text-4xl mb-4">About</h1>
      <p className="mb-4">
        Waray, also known as Waray-Waray, is an Austronesian language spoken by
        around 3 million people in the Eastern Visayas region of the
        Philippines, particularly on the islands of Samar, Leyte, and Biliran.
        It is one of the major languages of the country, recognized as a
        regional language and widely used in both informal and formal settings,
        including media and education.
      </p>
      <p>
        Waray belongs to the Visayan language family, which also includes
        Cebuano and Hiligaynon, but it has distinct features that set it apart.
        The language is primarily spoken in daily life but is also preserved
        through literature, folk songs, and oral traditions. It is often used
        alongside Tagalog (Filipino) and English, which are more prevalent in
        national discourse and formal communication.
      </p>
    </div>
  );
}
