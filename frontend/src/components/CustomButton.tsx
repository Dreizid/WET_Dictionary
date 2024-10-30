import React, { ReactNode } from 'react'

interface CustomButtonProps {
  children: ReactNode | JSX.Element;
  onClick: Function;
  value: String;
}
export const CustomButton = ({ children, onClick, value }: CustomButtonProps) => {
  return (
    <button className='bg-gray-800 text-sm py-2 px-4 mr-2 rounded-md' onClick={() => onClick(value)}>
      {children}
    </button>
  )
}
