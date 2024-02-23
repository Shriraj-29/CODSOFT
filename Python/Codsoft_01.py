import tkinter as tk
from tkinter import messagebox, simpledialog

class ToDoApp:
    def __init__(self, master):
        self.master = master
        self.master.title("To-Do List")

        # Styling
        self.master.configure(bg="#f0f0f0")
        self.master.geometry("265x350")

        self.tasks = []

        self.task_entry = tk.Entry(self.master, width=30, bd=2)
        self.task_entry.grid(row=0, column=0, padx=10, pady=10, columnspan=2)

        self.add_button = tk.Button(self.master, text="Add Task", command=self.add_task, width=10)
        self.add_button.grid(row=1, column=0, padx=10, pady=10)

        self.update_button = tk.Button(self.master, text="Update Task", command=self.update_task, width=10)
        self.update_button.grid(row=1, column=1, padx=10, pady=10)

        self.delete_button = tk.Button(self.master, text="Delete Task", command=self.delete_task, width=10)
        self.delete_button.grid(row=2, column=0, padx=10, pady=10)

        self.exit_button = tk.Button(self.master, text="Exit", command=self.master.destroy, width=10)
        self.exit_button.grid(row=2, column=1, padx=10, pady=10)

        self.task_listbox = tk.Listbox(self.master, width=40, height=10, bd=2)
        self.task_listbox.grid(row=3, column=0, columnspan=2, padx=10, pady=10)

    def add_task(self):
        task = self.task_entry.get()
        if task:
            self.tasks.append(task)
            self.task_listbox.insert(tk.END, task)
            self.task_entry.delete(0, tk.END)
        else:
            messagebox.showwarning("Warning", "Please enter a task.")

    def update_task(self):
        selected_index = self.task_listbox.curselection()
        if selected_index:
            new_task = simpledialog.askstring("Input", "Enter new task:")
            if new_task:
                self.tasks[selected_index[0]] = new_task
                self.task_listbox.delete(selected_index)
                self.task_listbox.insert(selected_index, new_task)
        else:
            messagebox.showwarning("Warning", "Please select a task to update.")

    def delete_task(self):
        selected_index = self.task_listbox.curselection()
        if selected_index:
            task_to_delete = self.tasks[selected_index[0]]
            confirmation = messagebox.askyesno("Confirmation", f"Are you sure you want to delete '{task_to_delete}'?")
            if confirmation:
                self.tasks.pop(selected_index[0])
                self.task_listbox.delete(selected_index)
        else:
            messagebox.showwarning("Warning", "Please select a task to delete.")

if __name__ == "__main__":
    root = tk.Tk()
    app = ToDoApp(root)
    root.mainloop()
