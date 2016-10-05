package il.ac.hit.todolist.model;

public class Tester {

	public static void main(String[] args) {
		ToDoListService service = new ToDoListService();

		User ramiUser = service.addUser("Rami Saidov", "ramis", "1234");
		System.out.println("added rami user");
		int userId = service.authenticateUser("ramis", "4321");
		if (userId != Integer.MIN_VALUE) {
			System.out
					.println("ramis user was authenticated, altough password was wrong. user id = "
							+ userId);
		} else {
			System.out.println("rami was not authenticated. this is good.");
		}

		User orenUser = service.addUser("Oren Brikman", "orenb", "555");
		System.out.println("added oren user");
		userId = service.authenticateUser("orenb", "555");
		if (userId != Integer.MIN_VALUE) {
			System.out
					.println("oren was authenticated. this is good. user id = "
							+ userId);
		} else {
			System.out.println("oren was not authenticated. this is not good.");
		}

		Item ramiItem = service.addItem("Finish Project",
				"Need to finish this project", ramiUser.getId());
		System.out.println("added item: Finish project");
		ramiItem.setTitle("Finish Model!!");
		service.updateItem(ramiItem);
		System.out.println("previous item was updated. new title is :"
				+ ramiItem.getTitle() + ", done was set to true");

		Item orenItem = service.addItem("More work!!!", "work description...",
				orenUser.getId());
		System.out
				.println("new item was added. title = " + orenItem.getTitle());
		service.deleteItem(orenItem.getId());
		System.out.println("previous item was deleted.");

		System.out.println("Printing all items: ");
		for (Item item : service.getItems()) {
			System.out.println("Title: " + item.getTitle() + ", Description: "
					+ item.getDescription());
		}

		System.out.println("Close DAO");
		service.CloseDAO();
	}

}
