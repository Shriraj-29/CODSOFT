import json

class ContactManager:
    def __init__(self):
        self.contacts = []

    def load_contacts(self):
        try:
            with open("contacts.json", "r") as file:
                self.contacts = json.load(file)
        except FileNotFoundError:
            pass

    def save_contacts(self):
        with open("contacts.json", "w") as file:
            json.dump(self.contacts, file, indent=4)

    def add_contact(self, name, phone_number, email, address):
        self.contacts.append({
            "name": name,
            "phone_number": phone_number,
            "email": email,
            "address": address
        })
        self.save_contacts()

    def view_contacts(self):
        if not self.contacts:
            print("No contacts found.")
        else:
            for i, contact in enumerate(self.contacts, start=1):
                print(f"{i}. {contact['name']}: {contact['phone_number']}")

    def search_contact(self, query):
        found_contacts = []
        for contact in self.contacts:
            if query.lower() in contact["name"].lower() or query in contact["phone_number"]:
                found_contacts.append(contact)
        return found_contacts

    def update_contact(self, index, new_name=None, new_phone=None, new_email=None, new_address=None):
        contact = self.contacts[index]
        if new_name:
            contact["name"] = new_name
        if new_phone:
            contact["phone_number"] = new_phone
        if new_email:
            contact["email"] = new_email
        if new_address:
            contact["address"] = new_address
        self.save_contacts()

    def delete_contact(self, index):
        del self.contacts[index]
        self.save_contacts()

def main():
    manager = ContactManager()
    manager.load_contacts()

    while True:
        print("\nContact Management System")
        print("1. Add Contact")
        print("2. View Contact List")
        print("3. Search Contact")
        print("4. Update Contact")
        print("5. Delete Contact")
        print("6. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            name = input("Enter name: ")
            phone_number = input("Enter phone number: ")
            email = input("Enter email: ")
            address = input("Enter address: ")
            manager.add_contact(name, phone_number, email, address)
            print("Contact added successfully.")

        elif choice == "2":
            manager.view_contacts()

        elif choice == "3":
            query = input("Enter name or phone number to search: ")
            found_contacts = manager.search_contact(query)
            if found_contacts:
                print("Search results:")
                for contact in found_contacts:
                    print(f"Name: {contact['name']}, Phone: {contact['phone_number']}")
            else:
                print("No matching contacts found.")

        elif choice == "4":
            index = int(input("Enter index of contact to update: ")) - 1
            if 0 <= index < len(manager.contacts):
                new_name = input("Enter new name (leave empty to keep current): ")
                new_phone = input("Enter new phone number (leave empty to keep current): ")
                new_email = input("Enter new email (leave empty to keep current): ")
                new_address = input("Enter new address (leave empty to keep current): ")
                manager.update_contact(index, new_name, new_phone, new_email, new_address)
                print("Contact updated successfully.")
            else:
                print("Invalid index.")

        elif choice == "5":
            index = int(input("Enter index of contact to delete: ")) - 1
            if 0 <= index < len(manager.contacts):
                manager.delete_contact(index)
                print("Contact deleted successfully.")
            else:
                print("Invalid index.")

        elif choice == "6":
            print("Exiting...")
            break

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
