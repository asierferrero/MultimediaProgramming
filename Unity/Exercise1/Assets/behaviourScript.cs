using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class behaviourScript : MonoBehaviour
{
    public float speed = 5f;
    public string direction;
    public Vector3 movement;

    // Start is called before the first frame update
    void Start()
    {
        // Define the initial position
        transform.position = Vector3.zero;
        direction = "Forward";
        movement = Vector3.forward;
    }

    // Update is called once per frame
    void Update()
    {
        // Move the object
        transform.position += movement * speed * Time.deltaTime;

        // Define the movement and rotation depending on each direction
        if (direction.Equals("Forward") && transform.position.z >= 10)
        {
            direction = "Right";
            movement = Vector3.right;
            transform.Rotate(Vector3.up, 90f);
        }
        else if (direction.Equals("Right") && transform.position.x >= 10)
        {
            direction = "Back";
            movement = Vector3.back;
            transform.Rotate(Vector3.up, 90f);
        }
        else if (direction.Equals("Back") && transform.position.z <= 0)
        {
            direction = "Left";
            movement = Vector3.left;
            transform.Rotate(Vector3.up, 90f);
        }
        else if (direction.Equals("Left") && transform.position.x <= 0)
        {
            direction = "Forward";
            movement = Vector3.forward;
            transform.Rotate(Vector3.up, 90f);
        }
    }
}
