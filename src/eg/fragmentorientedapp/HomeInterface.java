package eg.fragmentorientedapp;

import eg.fragmentorientedapp.InterFragmentCommunication.GreetingsInterface;
import eg.fragmentorientedapp.PersistentUI_Fragment.ListDetailInterface;
import eg.fragmentorientedapp.base.DrawerActivityInterface;
import eg.fragmentorientedapp.base.HostActivityInterface;
import eg.fragmentorientedapp.utils.FacebookInterface;

public interface HomeInterface
extends HostActivityInterface,
		DrawerActivityInterface,
		FacebookInterface,
		GreetingsInterface,
		ListDetailInterface
{}