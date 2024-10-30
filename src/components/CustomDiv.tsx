import React, { ReactNode } from 'react'

interface WrapperProps {
  children?: ReactNode | JSX.Element;
  className?: string
}
export const CustomDiv : React.FC<WrapperProps> = ({children, className}) => {
  return (
    <div className={`bg-slate-800/50 border-slate-700 p-6 rounded-xl border ${className}`}>
      {children}
    </div>
  )
}
