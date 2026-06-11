import React from 'react'
import { Users } from 'lucide-react'

const HeaderComponent = () => {
    return (
        <div>
            <header>
                <nav className='navbar navbar-expand-md navbar-dark bg-primary px-4 py-3 shadow-sm'>
                    <a className='navbar-brand d-flex align-items-center gap-2' href='/'>
                        <Users size={24} />
                        <span className="fw-bold fs-4">Employee Management System</span>
                    </a>
                </nav>
            </header>
        </div>
    )
}

export default HeaderComponent
